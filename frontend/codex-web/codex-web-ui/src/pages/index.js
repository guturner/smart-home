import * as React from "react"
import { Link } from "gatsby"

import Layout from "../components/layout/layout"
import Seo from "../components/seo"
import * as styles from "../components/index.module.css"
import CodexPageListComponent from "../components/codexpage/codexpagelist"

const IndexPage = () => (
  <Layout>
    <Seo title="Home" />

    <div className={styles.textCenter}>
      <h1>
        Hello, world!
      </h1>
    </div>

    <CodexPageListComponent />

  </Layout>
)

export default IndexPage
