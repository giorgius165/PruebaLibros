import React from "react";
import LibroItem from "./LibroItem"
import LibroCount from "./LibroCount"
import Update from "./Update"

export default class LibroList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { libros: [] }
	}

  render() {
		if (this.state.libros.length == 0) {	
			fetch('/api/v1/libro/list/')
			.then((response) => {
				return response.json();
			})			
			.then((libro) => {
        		this.setState({ libros: libro })
      		})
			
		}

		if (this.state.libros.length > 0) {
		
			var libroItems = [];
			this.state.libros.forEach(
				(libro) => {
					libroItems.push(<LibroItem libro={libro} />)
				}
			)
		
		return (
				<div>
					{libroItems}
					<LibroCount  count={libroItems.length}/>
				</div>
			)
			
		
		} else {
			return <p className="text-center">Loading books...</p>
		}  
  }
}