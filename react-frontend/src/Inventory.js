import { useState, useEffect } from "react";
function FetchInventory () {
    const [data, setData] = useState(null);

    async function fetchData() {
        try {
            const response = await fetch('http://localhost:9000/inventory');
            if(!response.ok) {
                throw new Error('Network response was not ok');
            }
            const results = await response.json();
            setData(results);
        }  catch (error) {
        console.error('Error fetching data:', error)
        }
    }

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div>
            {data && data.map(item => (
                <div>
                    <h3>{item.name}</h3>
                    <p>Description: {item.description}</p>
                    <p>Quantity: {item.quantity}</p>
                    <p>Price: ${item.price}</p>
                    <p>Id: {item.id}</p>
                    <hr />
                </div>
            ))}
        </div>
    )
}

export default function Inventory() {
    return (
        <div>
            <h1>Inventory</h1>
            <FetchInventory />
        </div>
    )
}