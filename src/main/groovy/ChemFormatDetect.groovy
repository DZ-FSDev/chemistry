String ChemFormatDetect(String input){
  Reader stringReader = new StringReader(input)
  FormatFactory factory = new FormatFactory();
  IChemFormat format = factory.guessFormat(stringReader);
  return format.getFormatName();
}
