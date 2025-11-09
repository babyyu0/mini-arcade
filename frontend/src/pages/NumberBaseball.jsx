import { useState } from "react";
import Category from "../components/Category";
import NumberInput from "../components/NumberInput";
import Title from "../components/Title";
import '../css/NumberBaseball.css'

function NumberBaseball() {
    const [numbers, setNumbers] = useState([0, 0, 0]);

    return (
        <>
            <Category activeFrame={'numberBaseball'} />
            <Title title={'숫자 야구 게임'} />
            <div className='baseball-frame'>
                <div className='baseball-contents'>
                <div className='baseball-input'>
                    <NumberInput number={numbers.length >= 1? numbers.at(0) : 0} />
                    <NumberInput number={numbers.length >= 1? numbers.at(1) : 0}  />
                    <NumberInput number={numbers.length >= 1? numbers.at(2) : 0}  />
                </div>
                </div>
            </div>
        </>
    );
}

export default NumberBaseball