import { useRef, useState } from "react";
import "./NumberBaseball.css"
import axios from "axios";

function NumberBaseball() {
    const [count, setCount] = useState(3);
    const [numberList, setNumberList] = useState(['', '', '']);
    const numberRefs = useRef([]);

    const numberChange = (value, index) => {
        value.replace(/[^0-9]/g, '');
        const resultNumberList = [...numberList];
        resultNumberList[index] = value;
        setNumberList(resultNumberList);

        if(index + 1 < count) {
            numberRefs.current[index + 1]?.focus();
        }
    }

    const submitCorrection = async () => {
        const numberListStr = numberList.toString().replaceAll(',', '');
        await axios.get(`http://localhost:8080/number-baseball/submit?submitNum=${numberListStr}`)
        .then((response) => {
            console.log(response);
        });
        ;
    }

    return (
        <div className="frame">
            <div className="container">
            <header>
                <h2>⚾ 숫자야구</h2>
                <p>랜덤으로 생성된 {count}자리 숫자를 맞춰보세요!</p>
            </header>
            <main>
                <section className="game-section">
                    <div className="game-frame">
                        {
                            numberList.map((number, index) => (
                                <input type="number" min="0" max="1" placeholder='0' value={number}
                                key={index}
                                ref={(el) => (numberRefs.current[index] = el)}
                                onFocus={()=> numberRefs.current[index]?.select()}
                                onChange={(e) => numberChange(e.target.value, index)} />
                            ))
                        }
                    </div>
                    <button class="throw-btn" onClick={submitCorrection}>공 던지기! (Throw)</button>
                </section>
            </main>
            </div>
        </div>
    );
}

export default NumberBaseball;