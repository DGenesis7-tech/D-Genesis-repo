import React from "react";
import { useGetAllProductsQuery } from "../apis/productApis";
import styles from "./products.module.css";

const Products = ()=> {

    const data = useGetAllProductsQuery();
    console.log(data.data);


    return(
        <div className={styles.productContainer}>
            {
                data?.data?.map((product)=> (
                    <div key={product.id}>
                        <img src={`${product.image}`} alt="" />
                        <h1>{product.title}</h1>
                        <h2>{product.category}</h2>
                        <p>{product.price}</p>
                    </div>
                ))
            }

        </div>
    )
}

export default Products;