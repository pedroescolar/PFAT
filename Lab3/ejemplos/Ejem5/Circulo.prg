PF2018 Circulo 

vars
int i;

size(410, 410);

while (i<2000) do
  plot(blue, 5+Real2Int(200. * (1.+seno(Int2Real(i)*pi/1000.))), 
           5+Real2Int(200. * (1.+coseno(Int2Real(i)*pi/1000.))));
  i:=i+1;
end;


