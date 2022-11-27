import './App.css';
import Login from './Components/Login';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Admin from './Components/Admin/Admin';
import Author from './Components/Author/Author';
import AddItem from './Components/Author/AddItem';
import GenerateQuesPaper from './Components/Author/GenerateQuesPaper';
import ShowPaper from './Components/Author/ShowPaper';
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/adminPage" element={<Admin/>}/>
        <Route path="/authorPage" element={<Author/>}></Route>
        <Route path="/addItem" element={<AddItem/>}></Route>
        <Route path="/generateQuesPaper" element={<GenerateQuesPaper/>}></Route>
        <Route path="/showPaper" element={<ShowPaper/>}></Route>
      </Routes>
    </Router>
  );
}

export default App;
