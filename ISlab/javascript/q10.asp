<html>
<body>
<%
dim ans1,ans2,ans3
answ1=Request.Form("ans1")
answ2=Request.Form("ans2")
answ3=Request.Form("ans3")
%>
<form name="quiz" method="post" action="que10.asp">
   Q1 :- What is the name of our current president<br/><br/>
   <table>
   <tr>
   <td>a)<input type="radio" name="ans1" value="a"> Pratibha Patil</td><td>&nbsp &nbsp &nbsp &nbsp b)<input type="radio" name="ans1" value="b">  Mayawati</td>
   </tr>
   <tr>
   <td>c)<input type="radio" name="ans1" value="c"> shiela Dikshit</td><td>&nbsp &nbsp &nbsp &nbsp d)<input type="radio" name="ans1" value="d">  Rabri Devi</td>
  </tr>
		</table>
		<br/>
		<%If answ1="a" Then Response.Write("Correct Answer <br/>") Else If answ1="" Then Response.Write("") Else Response.Write("Wrong Answer <br/>") End if%><br/>
		Q2 :- What is the name of our current prime minister<br/><br/>
		<table>
			<tr>
				<td>a)<input type="radio" name="ans2" value="a"> Sonia Gandhi</td><td>&nbsp &nbsp &nbsp &nbsp b)<input type="radio" name="ans2" value="b">  Narendra Modi</td>
			</tr>
			<tr>
				<td>c)<input type="radio" name="ans2" value="c"> Prathibha Patil</td><td>&nbsp &nbsp &nbsp &nbsp d)<input type="radio" name="ans2" value="d">  Manmohan Singh</td>
			</tr>
		</table>
		<br/>
		<%If answ2="d" Then Response.Write("Correct Answer <br/>") Else If answ2="" Then Response.Write("") Else Response.Write("Wrong Answer <br/>") End if%>
		Q3 :- What is the name of our current captain of Indian Cricket Team <br/><br/>
		<table>
			<tr>
				<td>a)<input type="radio" name="ans3" value="a"> Yuvraj Singh</td><td>&nbsp &nbsp &nbsp &nbsp b)<input type="radio" name="ans3" value="b">  Virendra Sehwag</td>
			</tr>
			<tr>
				<td>c)<input type="radio" name="ans3" value="c"> Sachin Tendulkar</td><td>&nbsp &nbsp &nbsp &nbsp d)<input type="radio" name="ans3" value="d">  M S Dhoni</td>
			</tr>
		</table>
		<br/>
		<%If answ3="d" Then Response.Write("Correct Answer <br/>") Else If answ3="" Then Response.Write("") Else Response.Write("Wrong Answer <br/>") End if%>
		<input type="submit" value="SUBMIT">
		</form>
 </body>
</html>
