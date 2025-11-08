import { useState, useEffect } from 'react'
import Title from '../components/Title'
import '../css/Strengthening.css'
import axios from 'axios';
import Category from '../components/Category';

function Strengthening() {

    const [userInfo, setUserInfo] = useState({ip: null, money: 100000})
    const [weaponInfo, setWeaponInfo] = useState({})
    const [totalPrice, setTotalPrice] = useState(0);
    const [success, setSuccess] = useState(0);
    const BACKEND_URL = 'http://localhost:8080/strengthening';

    /* 처음부터 시작 */
    const handleInit = async () => {
        const geoResponse = await axios.get('https://geolocation-db.com/json/');
        if(geoResponse.status != 200) {
            alert("서버에 문제가 발생했습니다. 잠시 후에 다시 시도해주세요.");
            return false;
        }

        const ipAddress = geoResponse.data.IPv4;

        // 게임 초기에 필요한 정보 삽입
        const initResponse = await axios.post(`${BACKEND_URL}/init`, { ip: ipAddress });
        if(initResponse.status != 200) {
            alert("서버에 문제가 발생했습니다. 잠시 후에 다시 시도해주세요.");
            return false;
        }

        const initData = initResponse.data;
        setUserInfo(initData.user);
        setWeaponInfo(initData.weapon);

        console.log(initData);
    }

    /* 첫 로드 시 불리는 메서드 */
    useEffect(() => {
        handleInit();
    }, []);

    /* 해당 확률이 성공했는지 여부를 반환하는 메서드 */
    const isProbilitySuccess = (probability) => {
        const randNum = Math.random() * 100 + 1;
        console.log("랜덤 넘버는 ", randNum, "입니다!");

        return (randNum <= probability);
    }

    /* 무기 강화하기 */
    const handleStrengthenWeapon = async () => {
        const response = await axios.post(`${BACKEND_URL}/strengthen`, userInfo);
        const data = response.data;
        setUserInfo(data.user);
        setWeaponInfo(data.weapon);
        setSuccess((data.weapon.level != 1) ? 'success' : 'failed');
    }

    /* 무기 판매하기 */
    const handleSellWeapon = async () => {
        const response = await axios.post(`${BACKEND_URL}/sell`, userInfo);
        const data = response.data;
        setUserInfo(data.user);
        setWeaponInfo(data.weapon);
    }

    return (
        <>
            <Category />
            <Title title={"드래곤볼 전투력 강화하기"} />
            <div className='weapon-frame'>
                <div className='weapon-contents'>
                    <div className='weapon-info'>
                        <div className='weapon-image'><img src={`../../public/lv${weaponInfo.level}.gif`} /></div>
                        <div className='weapon-desc'>{weaponInfo.description}</div>
                        <div className='weapon-name'>+{weaponInfo.level} {weaponInfo.name}</div>
                    </div>
                    <div className='user-select'>
                        <div className='user-money'>{userInfo.money.toLocaleString()} 캐시</div>
                        <div className='total-price'>누적 강화비용: {totalPrice.toLocaleString()} 캐시</div>
                        <div className='weapon-price'><b>판매가</b>: {weaponInfo.price ? weaponInfo.price.toLocaleString() : '0'} 캐시</div>
                        <div className='strengthening-cost'><b>강화 비용</b>: {weaponInfo.strengtheningCost ? weaponInfo.strengtheningCost.toLocaleString() : '0'} 캐시</div>
                        <div className='success-per'>(성공 확률: {weaponInfo.successPer ? weaponInfo.successPer : '0'}%)</div>
                        <button onClick={handleStrengthenWeapon}>강화하기</button>
                        <button onClick={handleSellWeapon}>판매하기</button>
                        <div className={`is-success ${success}`}>강화 성공!</div>
                        <div className={`is-failed ${success}`}>강화 실패!</div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Strengthening
