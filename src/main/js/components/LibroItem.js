import React from "react";
import Update from "./Update"
export default class LibroItem extends React.Component {

	constructor(props) {
		super(props)
	}

  render() {

    const { libro } = this.props;
  
    return (
      <div class="well col-md-4 col-md-offset-4" key={libro.id}>
        nombre: {libro.nombre} autor: {libro.autor}<br/>
        <Update id={libro.id}/>
      </div> 
    );
  }
}
