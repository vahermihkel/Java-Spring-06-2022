import { useRef } from 'react';

function AddProduct() {
  const nameRef = useRef();
  const priceRef = useRef();
  const imgSrcRef = useRef();
  const activeRef = useRef();

  const addNewProduct = () => {
    const newProduct = {
      name: nameRef.current.value,
      price: priceRef.current.value,
      imgSrc: imgSrcRef.current.value,
      active: activeRef.current.checked
    }
    fetch("http://localhost:8080/products",{
      method: "POST",
      body: JSON.stringify(newProduct),
      headers: {
        "Content-Type": "application/json"
      }
    })
  }


  return ( 
    <div>
      <label>Toote nimi</label> <br/>
      <input ref={nameRef} type="text" /> <br/>
      <label>Toote hind</label> <br/>
      <input ref={priceRef} type="number" /> <br/>
      <label>Toote pilt</label> <br/>
      <input ref={imgSrcRef} type="text" /> <br/>
      <label>Toote aktiivsus</label> <br/>
      <input ref={activeRef} type="checkbox" /> <br/>
      <button onClick={() => addNewProduct()}>Lisa uus toode</button>
    </div>
   );
}

export default AddProduct;