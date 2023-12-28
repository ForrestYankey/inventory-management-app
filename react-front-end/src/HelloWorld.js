import { useState } from "react";

function MyButton() {

    const [data, setData] = useState(null);

    async function helloWorld () {
        try {
            const response = await fetch('http://localhost:9000/hello');

            if(!response.ok) {
                throw new Error('Network response was not ok');
            }

            const result = await response.json();
            setData(result);
        } catch (error) {
            console.error('Error fetching data:', error)
        }
    }

    return (
        <div>
            <button onClick={helloWorld}>
                I'm a button
            </button>
            {data && (
                <p>{data.helloWorld}</p>
            )}
        </div>
    );
  }
  
  export default function MyApp() {
    return (
      <div>
        <h1>Welcome to my app</h1>
        <MyButton />
      </div>
    )
  }