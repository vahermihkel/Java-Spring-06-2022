import { useEffect, useState } from 'react';

function HomePage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/products")
    .then(res => res.json())
    .then(data => setProducts(data));
    // products = data;
  }, []);

  return ( 
    <div>
      {products.map(product => 
        <div>
          <div>{product.name}</div>
          <button>Lisa ostukorvi</button>
        </div>)}
    </div>
   );
}

export default HomePage;

// ctrl + *