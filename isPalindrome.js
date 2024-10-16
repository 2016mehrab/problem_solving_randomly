function isPalindrome(s) {
  let b = 0;
  let f = s.length - 1;
  while (f > b) {
    let fcode = s.charCodeAt(f);
    let bcode = s.charCodeAt(b);
    if (
      !((fcode >= 48 && fcode <= 57) ||
      (fcode >= 65 && fcode <= 90) ||
      (fcode >= 97 && fcode <= 122))
    )  {

        --f;
        continue;
      }
    if (
      !((bcode >= 48 && bcode <= 57) ||
      (bcode >= 65 && bcode <= 90) ||
      (bcode >= 97 && bcode <= 122))
    )  {
        ++b;
        continue;
    }
    if (s[b].toLowerCase() !== s[f].toLowerCase()) return false;
        --f;
        ++b;
  }
  return true;
}
