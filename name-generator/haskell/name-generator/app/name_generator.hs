import Text.Regex.Posix
import System.IO
import System.Random

main :: IO ()

testRegex :: String -> Bool
testRegex s = s =~ "[a-zA-Z]+" :: Bool
getRandomElement  :: [a] -> IO a
getRandomElement l = do
    i <- randomRIO (0, length l - 1)
    return $ l !! i

gender = "male"
lastNamePath = "../../name_data/dist.all.last"
femaleFirstPath = "../../name_data/dist.female.first"
maleFirstPath = "../../name_data/dist.male.first"

main = do
    lastNamesFile <- readFile lastNamePath
    femaleFirstFile <- readFile femaleFirstPath
    maleFirstFile <- readFile maleFirstPath
    let splitFemaleFirst = words femaleFirstFile
    let splitMaleFirst = words maleFirstFile
    let splitLastNames = words lastNamesFile
    let testedLastNames = filter testRegex splitLastNames
    let testedFemaleNames = filter testRegex splitFemaleFirst
    let testedMaleNames = filter testRegex splitMaleFirst
    firstName <- if gender == "female" 
                    then getRandomElement testedMaleNames 
                    else getRandomElement testedFemaleNames
    lastName <- getRandomElement testedLastNames
    let name = firstName ++ " " ++ lastName
    print name
