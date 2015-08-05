import org.tartarus.snowball.ext.EnglishStemmer
import chalk.text.tokenize.JavaWordTokenizer
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.linalg.Vector

def splitIntoWords(s: String): List[String] = JavaWordTokenizer(s).toList

def stripSpecialAndNumeric(s: String) = s.replaceAll("[^-'A-Za-z ]", "")

def stemWord(s: String): String = {
  val stemmer = new EnglishStemmer //TODO: Use static stemmer
  stemmer.setCurrent(s)
  stemmer.stem
  stemmer.getCurrent
}

val words = sc.makeRDD(List("Say", "Said", "Saying"))

val stemMap = words.map{ word => (stemWord(word), word) }
val stems = stemMap.map{ case(stem, word) => List(stem) }
stems.collects

val tf = new HashingTF().transform(stems)
tf.collect