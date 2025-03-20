import {defineConfig} from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Axi Documentation",
  description: "A modern Minecraft game engine",
  srcDir: 'src',

  themeConfig: {
    nav: [
      {text: 'Home', link: '/'},
      {text: 'Introduction', link: '/introduction'},
      {text: 'Examples', link: '/examples'}
    ],

    search: {
      provider: 'local'
    },

    sidebar: [
      {
        text: 'Getting Started',
        items: [
          {text: 'Introduction', link: '/getting-started/introduction'},
          {text: 'Quickstart', link: '/getting-started/quickstart'},
          {text: 'Applying KSP', link: '/getting-started/ksp'},
          {text: 'Examples', link: '/getting-started/examples'},
        ]
      },
      {
        text: 'Core APIs',
        items: [
          {text: 'Entity Component System', link: '/core-apis/ecs'},
          {text: 'Commands', link: '/core-apis/commands'},
          {text: 'Coroutines', link: '/core-apis/coroutines'},
        ]
      },
      {
        text: 'UI',
        items: [
          {text: 'Text API', link: '/ui/text'},
          {text: 'Resource Packs', link: '/ui/resource-packs'},
          {text: 'Fonts', link: '/ui/fonts'},
          {text: 'Sprites', link: '/ui/sprites'},
          {text: 'Rendering API', link: '/ui/rendering'},
        ]
      }
    ],

    socialLinks: [
      {icon: 'github', link: 'https://github.com/radstevee/axi'}
    ]
  },
})
