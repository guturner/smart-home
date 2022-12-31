module.exports = {
  siteMetadata: {
    title: `Codex`,
    description: `A wiki site for world building.`,
    author: `Guy Turner`,
    siteUrl: `https://github.com/guturner`,
  },

  plugins: [
    `gatsby-plugin-react-helmet`,
    `gatsby-plugin-image`,
    {
      resolve: `gatsby-source-filesystem`,
      options: {
        name: `assets`,
        path: `${__dirname}/src/assets`,
      },
    },
    `gatsby-transformer-sharp`,
    `gatsby-plugin-sharp`,
    {
      resolve: `gatsby-plugin-manifest`,
      options: {
        name: `gatsby-starter-default`,
        short_name: `starter`,
        start_url: `/`,
        background_color: `#663399`,
        display: `minimal-ui`,
        icon: `${__dirname}/src/assets/favicon.png`,
      },
    },
  ],
}
