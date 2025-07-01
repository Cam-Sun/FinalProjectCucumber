package utils

object FormatConversion {

  def normalizeProductName(name: String): String = {
    name.toLowerCase.replace(" ", "-")
  }
}
