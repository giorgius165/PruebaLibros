import React from "react";
import { addLibro } from "../actions/LibroActions"

export default class LibroForm extends React.Component {

  constructor() {
    super();
    this.state = {
    		
      nombre: "",
      autor: ""
    
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
    	this.addLibro();
      console.log("item inserted")
    }
  }

  addLibro() { 
	  addLibro(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <input type="text" class="form-control"
            name="nombre"
            placeholder="Add a new book's name..."
            value={this.state.nombre}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
        	name="autor"  
            placeholder="Add a new book's author ..."
            value={this.state.autor}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addLibro.bind(this)}>Insert Book</button>
        </div>
      </div>
    );
  }
}