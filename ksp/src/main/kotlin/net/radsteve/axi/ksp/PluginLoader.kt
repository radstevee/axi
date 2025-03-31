package net.radsteve.axi.ksp

public object PluginLoader {
  public const val CONTENT: String = """
package net.radsteve.axi.plugin.loader;

import com.google.gson.Gson;
import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class AxiPluginLoader implements PluginLoader {
  private record AxiPluginDependencies(
    Set<String> repos,
    Set<String> deps
  ) {
    public static AxiPluginDependencies loadFromResources(InputStream stream) {
      return new Gson().fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8), AxiPluginDependencies.class);
    }
  }

  @Override
  public void classloader(PluginClasspathBuilder classpathBuilder) {
    System.setProperty("net.kyori.adventure.text.warnWhenLegacyFormattingDetected", "false");
    
    try (InputStream stream = getClass().getResourceAsStream("/axi-dependencies.json")) {
      if (stream == null) {
        return;
      }

      AxiPluginDependencies deps = AxiPluginDependencies.loadFromResources(stream);
      MavenLibraryResolver resolver = new MavenLibraryResolver();

      deps.repos().forEach(repo ->
        resolver.addRepository(
          new RemoteRepository.Builder(
            repo,
            "default",
            repo
          ).build()
        )
      );

      deps.deps().forEach(dep ->
        resolver.addDependency(new Dependency(new DefaultArtifact(dep), null))
      );

      classpathBuilder.addLibrary(resolver);
    } catch (IOException ignored) {
    }
  }
}
  """
}
