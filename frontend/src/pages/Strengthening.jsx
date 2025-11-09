import { useState, useEffect } from 'react'
import Title from '../components/Title'
import '../css/Strengthening.css'
import axios from 'axios';
import Category from '../components/Category';

function Strengthening() {

    const [userInfo, setUserInfo] = useState({ ip: null, money: 0 })
    const [weaponInfo, setWeaponInfo] = useState({
        name: '로딩중',
        description: '잠시만 기다려주세요.',
        level: 0,
        strengtheningCost: 0,
        price: 0,
        successPer: 0
    })
    const [totalPrice, setTotalPrice] = useState(0);
    const [successStatus, setSuccessStatus] = useState(0);
    const BACKEND_URL = 'http://localhost:8080/strengthening';

    /* 처음부터 시작 */
    const handleInit = async () => {
        try {
            const geoResponse = await axios
                .get('https://geolocation-db.com/json/')
                .catch((response) => {
                    console.log(response);
                });
            const ipAddress = geoResponse.data.IPv4;

            // 게임 초기에 필요한 정보 삽입
            const initResponse = await axios.post(`${BACKEND_URL}/init`, { ip: ipAddress });

            const data = initResponse.data;
            setUserInfo(data.user);
            setWeaponInfo(data.weapon);
            setSuccessStatus(data.successStatus);
        } catch(error) {
            setWeaponInfo({name: error.message, level: 0})
            alert(`서버에 문제가 발생했습니다. (${error.message})\n잠시 후 다시 시도해주세요.`);
        }
    }

    /* 첫 로드 시 불리는 메서드 */
    useEffect(() => {
        handleInit();
    }, []);

    /* 무기 강화하기 */
    const handleStrengthenWeapon = async () => {
        try {
            const response = await axios.post(`${BACKEND_URL}/strengthen`, userInfo);
            const data = response.data;
            setUserInfo(data.user);
            setWeaponInfo(data.weapon);
            setTotalPrice(totalPrice + data.weapon.strengtheningCost);
            setSuccessStatus(data.successStatus);
            console.log(data);
        } catch(error) {
            setWeaponInfo({name: error.message, level: 0})
            alert(`서버에 문제가 발생했습니다. (${error.message})\n잠시 후 다시 시도해주세요.`);
        }
    }

    /* 무기 판매하기 */
    const handleSellWeapon = async () => {
        try {
            const response = await axios.post(`${BACKEND_URL}/sell`, userInfo);
            const data = response.data;
            setUserInfo(data.user);
            setWeaponInfo(data.weapon);
            setTotalPrice(0);
            setSuccessStatus(data.successStatus);
        } catch(error) {
            setWeaponInfo({name: error.message, level: 0})
            alert(`서버에 문제가 발생했습니다. (${error.message})\n잠시 후 다시 시도해주세요.`);
        }
    }

    return (
        <>
            <Category activeFrame={'strengthening'} />
            <Title title={'드래곤볼 전투력 강화하기'} />
            <div className='weapon-frame'>
                <div className='weapon-contents'>
                    <div className='weapon-info'>
                        <div className='weapon-image'><img src={`../../public/strengtheningResource/lv${weaponInfo.id}.gif`} /></div>
                        <div className='weapon-desc'>{weaponInfo.description}</div>
                        <div className='weapon-name'>+{weaponInfo.id}</div>
                        <div className='weapon-name'>전투력 {weaponInfo.energy}, {weaponInfo.name}</div>
                    </div>
                    <div className='user-select'>
                        <div className='user-money'>{userInfo.money.toLocaleString()} 캐시</div>
                        <div className='total-price'>누적 강화비용: {totalPrice.toLocaleString()} 캐시</div>
                        <div className='weapon-price'><b>판매가</b>: {weaponInfo.price ? weaponInfo.price.toLocaleString() : '0'} 캐시</div>
                        <div className='strengthening-cost'><b>강화 비용</b>: {weaponInfo.strengtheningCost ? weaponInfo.strengtheningCost.toLocaleString() : '0'} 캐시</div>
                        <div className='success-per'>(성공 확률: {weaponInfo.successPer ? weaponInfo.successPer : '0'}%)</div>
                        <button onClick={handleStrengthenWeapon}>강화하기</button>
                        <button onClick={handleSellWeapon}>판매하기</button>
                        <div className={`is-success ${successStatus == 1 ? 'active':''}`}>강화 성공!</div>
                        <div className={`is-success ${successStatus == 2 ? 'active':''}`}>강화 실패!</div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Strengthening
