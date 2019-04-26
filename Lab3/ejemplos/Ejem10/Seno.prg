PF2018 Diagonal1 (ancho, color) 

vars
int i, j, color2;

size(210, ancho);

j:=10;

color2:= color;

if (color=7)
then color2:=1;
end;

while (i<ancho*j) do
  if (color2=1) then
    plot(black, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  if (color2=2) then
    plot(grey, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  if (color2=3) then
    plot(blue, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  if (color2=4) then
    plot(red, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  if (color2=5) then
    plot(green, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  if (color2=6) then
    plot(yellow, i/j, 
         5 + Real2Int(1e2 * (1.0 + seno(pi * Int2Real(i)/(Int2Real(j) *
	 0.4E2)))));
  end;

  i:=i+1;

  if (color=7 and 200 * (i/200)=i)
  then 
    if color2=6
    then color2:=1;
    else color2:= color2+1;
    end;
  end;
end;



