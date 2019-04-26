PF2018 ErrSem6 (ancho, alto, vertice) 

vars
int i, j;
real a, b, c;

size(alto, ancho);

if not ((vertice<0) or (vertice>(ancho-1))) 
then
  while (i<ancho) do
    plot(black, i, 0);
    i:=i+1;
  end;
  i:=1;
  a:= Int2Real(alto)/Int2Real(vertice);
  b:= Int2Real(alto)/(Int2Real(ancho)-Int2Real(vertice));
  c:= b * Int2Real(ancho);
  plot(black, vertice, alto-1);
  
  while(i+(ancho-1)) do
    j:=1;
    while(j<(alto-1)) do
      if (i=vertice) then 
        plot(black, i, j);
      else 
        if (i<vertice) then
          if ((j<Real2Int(Int2Real(i)*a)) or
              (j=Real2Int(Int2Real(i)*a)))
          then
            plot(black, i, j);
          end;
        else
          if ((j<Real2Int(c - b * Int2Real(i))) or
              (j=Real2Int(c - b * Int2Real(i)))) 
          then 
            plot(black, i, j);
          end;
        end;
      end;
      j:=j+1;
    end; 
    i:=i + 1;
  end;
end;





