PF2018 Triangulo1 (ancho, alto, vertice) 

vars
int i;
real a, b, c;

size(alto, ancho);

if not ((vertice<0) or (vertice>(ancho-1))) 
then
  while (i<ancho) do
    plot(red, i, 0);
    i:=i+1;
  end;
  i:=2;
  a:= Int2Real(alto)/Int2Real(vertice);
  b:= Int2Real(alto)/(Int2Real(ancho)-Int2Real(vertice));
  c:= b * Int2Real(ancho);
  plot(red, vertice, alto-1);
  
  while(i<vertice) do
    plot(red, i, Real2Int(Int2Real(i)*a));
    i:=i + 2;
  end;

  i:= ancho-2;
  while(i>vertice) do
    plot(red, i, Real2Int(c - b * Int2Real(i)));
    i:=i-2;
  end;
end;





