PF2018 Zigzag (alto) 

vars
int i,j, delta;
bool control;

size(alto, 200);

control:=true;
delta:=4;

if (alto<1) then
  control:=false;
end;

while (control) do
  while (control and (j<180)) do
    plot(black, j+10, i);
    i:=i+1;
    if (i=alto) then
      control:=false;
    end;
    j:=j+delta;
  end;

  delta:=-delta;
  j:=j+delta;
  i:=i-1;

  while (control and (j>0)) do
    plot(black, j+10, i);
    i:=i+1;
    if (i=alto) then
      control:=false;
    end;
    j:=j+delta;
  end;

  delta:=-delta;
  j:=j+delta;
  i:=i-1;
end;


