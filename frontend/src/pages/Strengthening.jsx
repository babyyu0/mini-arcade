import { useState } from 'react'
import Title from '../components/Title'
import '../css/Strengthening.css'

function Strengthening() {
    const [level, setLevel] = useState(0)
    const [name, setName] = useState('부숴진 나뭇가지')

    const [userMoney, setUserMoney] = useState(1000000)
    const [strengtheningCost, setStrengtheningCost] = useState(0)
    const [weaponPrice, setWeaponPrice] = useState(0)

    // 무기 강화하기
    const handleStrengthenWeapon = () => {
        setLevel(level + 1)
    }

    return (
        <>
            <Title title={"검 강화하기"} />
            <div className='weapon-frame'>
                <div className='weapon-contents'>
                    <div className='weapon-info'>
                        <div className='weapon-image'><img src='../../public/lv0_branches.png' /></div>
                        <div className='weapon-name'>+{level} {name}</div>
                        <div className='weapon-price'>판매가 : {weaponPrice.toLocaleString()} 원</div>
                    </div>
                    <div className='user-select'>
                        <div className='user-money'>{userMoney.toLocaleString()} 원</div>
                        <div className='strengthening-cost'>강화 비용 : {strengtheningCost.toLocaleString()} 원</div>
                        <button onClick={handleStrengthenWeapon}>강화하기</button>
                        <button>판매하기</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Strengthening
