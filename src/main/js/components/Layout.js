import React from "react"
import { addLibro} from "../actions/libroActions"
import LibroForm from "./LibroForm"
import LibroList from "./LibroList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
	      <ActorForm />	
	      <LibroList />	
      </div>
    )
  }
}