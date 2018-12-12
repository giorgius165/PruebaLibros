import React from "react";


export default class Update extends React.Component {

	constructor(props) {
		super(props)
		this.state = { id: props.id }
	 	console.log(this.state)
    }
    
    update(event){
    	console.log(this.state.id)
        fetch('/api/v1/libro/update/?id='+this.state.id)
    }

  render() {
		
		return (
				<button onClick={this.update.bind(this)}>
					Cambiar Nombre
				</button>
			)
  }
}