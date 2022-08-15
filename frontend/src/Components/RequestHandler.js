import React from 'react';


class RequestHandler extends React.Component {
    constructor(props) {
      super(props);
      // the variables that need to change
      this.state = {
        email: '',
        response: ''
      };
  
      //Generally, if you refer to a method without () after it, 
      //such as onClick={this.handleClick}, you should bind that method.
      this.handleChange = this.handleChange.bind(this);
      this.handleClick = this.handleClick.bind(this);
    }
  
    //required for email state change
    handleChange(event) {
        this.setState({email: event.target.value});
    }

    // a process operates independently of other processes,
    async handleClick() {
      return fetch('api/orders/email/latest', {
      method: "POST",
      body: JSON.stringify({
        email: this.state.email,
      }),
      headers: { "Content-Type": "application/json" },
    }).then(response => response.json()).then(data => {
      this.state.response = JSON.stringify(data);
      //response state change
      this.setState({response: this.state.response});
     });
    }  
    
    render() {
        return (
            <div>
                <input type="text" value={this.state.value} onChange={this.handleChange} />
                <input type="submit" value="Run Test" onClick={this.handleClick}/>
                <br/>
                <p>{this.state.response}</p>
            </div>
        );
    }
}

export default RequestHandler;
