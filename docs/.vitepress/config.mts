import {defineConfig} from 'vitepress'
// import type {ThemeConfig} from 'vitepress-carbon'
// import baseConfig from 'vitepress-carbon/config'

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
          {text: 'Feature Overview', link: '/getting-started/feature-overview'},
          {text: 'Quickstart', link: '/getting-started/quickstart'},
          {text: 'Applying KSP', link: '/getting-started/ksp'},
          {text: 'Examples', link: '/getting-started/examples'},
        ]
      }
    ],

    socialLinks: [
      {icon: 'github', link: 'https://github.com/radstevee/axi'}
    ]
  },
})
