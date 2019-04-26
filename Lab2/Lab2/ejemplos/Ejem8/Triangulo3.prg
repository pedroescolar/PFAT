PF2018 Triangulo3 (ancho, alto, vertice) 

vars
int i, j;
real a, b, c;

size(alto, ancho);

j:=5;

if not ((vertice<0) or (vertice>(ancho-1))) 
then
  while (i<ancho) do
    plot(blue, i, 0);
    i:=i+1;
  end;
  i:=0;
  a:= Int2Real(alto)/Int2Real(vertice);
  b:= Int2Real(alto)/(Int2Real(ancho)-Int2Real(vertice));
  c:= b * Int2Real(ancho);
  plot(blue, vertice, alto-1);
  
  while(i<vertice*j) do
    plot(blue, i/j, Real2Int((Int2Real(i)*a)/Int2Real(j)));
    i:=i + 1;
  end;

  i:= (ancho-1)*j;
  while(i>vertice*j) do
    plot(blue, i/j, Real2Int(c - (b * Int2Real(i))/Int2Real(j)));
    i:=i-1;
  end;
end;





