import { Link } from 'react-router-dom';
import '../css/Category.css'

function Category({Category}) {
  return (
    <div className='category-frame'>
        <Link to={`/strengthening`}>드래곤볼 전투력 강화하기</Link>
        <Link>숫자 야구 게임</Link>
    </div>
  )
}

export default Category
