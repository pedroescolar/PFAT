PF2018 Mixto 

vars
int i, j;
int ancho, alto, vertice; 
real a, b, c;

size(400, 410);

ancho:=400;
alto:=300;
vertice:=200;

if not ((vertice<0) or (vertice>(ancho-1))) 
then
  while (i<ancho) do
    plot(green, i, 0);
    i:=i+1;
  end;
  i:=1;
  a:= Int2Real(alto)/Int2Real(vertice);
  b:= Int2Real(alto)/(Int2Real(ancho)-Int2Real(vertice));
  c:= b * Int2Real(ancho);
  plot(green, vertice, alto-1);
  
  while(i<(ancho-1)) do
    j:=1;
    while(j<(alto-1)) do
      if (i=vertice) then 
        plot(green, i, j);
      else 
        if (i<vertice) then
          if ((j<Real2Int(Int2Real(i)*a)) or
              (j=Real2Int(Int2Real(i)*a)))
          then
            plot(green, i, j);
          end;
        else
          if ((j<Real2Int(c - b * Int2Real(i))) or
              (j=Real2Int(c - b * Int2Real(i)))) 
          then 
            plot(green, i, j);
          end;
        end;
      end;
      j:=j+1;
    end; 
    i:=i + 1;
  end;
end;

alto:=200;
i:=5;

while (i<ancho) do
  plot(blue, i, alto-1);
  plot(blue, i, 40);
  i:=i+1;
end;

i:=40;

while (i<alto) do
  plot(blue, 5, i);
  plot(blue, (ancho-1), i);
  i:=i+1;
end;




