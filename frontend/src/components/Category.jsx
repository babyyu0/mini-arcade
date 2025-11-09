import { Link } from 'react-router-dom';
import '../css/Category.css'

function Category({activeFrame}) {
  return (
    <div className='category-frame'>
        <Link className={activeFrame == 'strengthening'? 'active':''} to={`/strengthening`}>드래곤볼 전투력 강화하기</Link>
        <Link className={activeFrame == 'numberBaseball'? 'active':''} to={`/number-baseball`}>숫자 야구 게임</Link>
    </div>
  )
}

export default Category
