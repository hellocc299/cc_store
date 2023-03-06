export function formatPrice(value: number) {
  let i = parseFloat(value.toString());
  if(isNaN(i)) { i = 0.00; }
  let minus = '';
  if(i < 0) { minus = '-'; }
  i = Math.abs(i);
  i = parseInt(((i + .005) * 100).toString());
  i = i / 100;
  let s = new String(i);
  if(s.indexOf('.') < 0) { s += '.00'; }
  if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
  s = minus + s;
  return s;
}
