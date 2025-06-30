package utils

object FormatConversion {

  def normalizeProductName(name: String): String = {
    name.toLowerCase.replaceAll("[^a-z0-9 ]", "").replace(" ", "-")
  }
}
