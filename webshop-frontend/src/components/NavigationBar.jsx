import { Link } from 'react-router-dom';

function NavigationBar() {
  return ( 
    <div>
      <Link to="/">
        <button>AVALEHELE</button>
      </Link>
      <Link to="/ostukorv">
        <button>OSTUKORVI</button>
      </Link>
      <Link to="/lisa-toode">
        <button>LISA TOODE</button>
      </Link>
    </div>
   );
}

export default NavigationBar;