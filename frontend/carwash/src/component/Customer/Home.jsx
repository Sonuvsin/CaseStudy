import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Home.css';
import { Link } from 'react-router-dom';

const FeaturedProducts = () => {
  const [products, setProducts] = useState([]);
useEffect(() => {
  fetchProducts();
}, []);
const fetchProducts = () => {
  axios
    .get('http://localhost:8080/user/washpack')
    .then((res) => {
      console.log(res);
      setProducts(res.data);
    })
    .catch((err) => {
      console.log(err);
    });
};

return (
  <div className='bg'>
  <h1>Featured Products</h1>
  <div className='item-container'>
    {products.map((product) => (
      <div className='card' key={product.id}>
        <h1>{product.name}</h1>
        <h3>{product.description}</h3>
        <h3>{product.cost} rupees</h3>
       <Link to = "/cust_home/order">
        <button className="bookBtn" onClick={()=>{History('/appointment')}}>Order Now <i className="fas fa-arrow-right rightArw"></i></button>
        </Link>
      </div>
    ))}
  </div>
</div>
  );
};
export default FeaturedProducts;
