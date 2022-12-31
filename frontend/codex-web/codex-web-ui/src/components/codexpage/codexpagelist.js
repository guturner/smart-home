import * as React from "react"
import axios from "axios"

import PropTypes from "prop-types"
import { useScrollRestoration } from "gatsby";

class CodexPageListComponent extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            newCodexPageTitle: '',
            codexPages: [],
        };
    }

    componentDidMount() {

        axios.get("http://localhost:8080/api/v1/codexPages").then(
            (response) => {
                this.setState({ codexPages: response.data.data });
            }
        );

        return this.state;
    }

    handleChange = event => {
        this.setState({ newCodexPageTitle: event.target.value });
    }

    createCodexPage = () => {
        const { newCodexPageTitle } = this.state;

        axios.post("http://localhost:8080/api/v1/codexPages", { "title" : newCodexPageTitle }).then(
            (response) => {
                
            }
        );
    }

    render = () => {

        const { codexPages } = this.state;

        return (
           
            <>
                <form onSubmit={this.createCodexPage}>
                    <input type="text" value={this.state.newCodexPageTitle} onChange={this.handleChange} /><button type="submit">Create New Codex Page</button>
                </form>
                

                <div>
                    {
                        codexPages.map( (codexPage) => (
                            <p key={codexPage.pageId}>Codex Page: {codexPage.title} id={codexPage.pageId}</p>
                        ))
                    }
                </div>
            </>
        )
    }
}
  
export default CodexPageListComponent