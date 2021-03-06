(def examples ["abcdef" "bababc" "abbcde" "abcccd" "aabcdd" "abcdee" "ababab"])

(defn groupByRepitions [word] (frequencies (seq word)))

(defn doGrouping [g] (map #(groupByRepitions %) g))

(defn selectKeysWithValue [groupedByRepitionsVector value] 
    (select-keys groupedByRepitionsVector 
        (for [[k v] groupedByRepitionsVector :when (= v value)] k)
    )
)

(defn removeEmpty [list]
    (remove empty? list)
)

(defn countThrees [vectorOfWords]
    (count
    (removeEmpty
    (map #(selectKeysWithValue % 3)
    (doGrouping vectorOfWords)
))))

(defn countTwos [vectorOfWords]
    (count
    (removeEmpty
    (map #(selectKeysWithValue % 2)
    (doGrouping vectorOfWords)
))))

(defn compute [vectorOfWords] 
    (reduce * [(countThrees vectorOfWords), (countTwos  vectorOfWords)])
)

(prn (str "Examples: " (compute examples) " = 12"))

(def inputPuzzle ["xrecqmdonskvzupalfkwhjctdb" "xrlgqmavnskvzupalfiwhjctdb" "xregqmyonskvzupalfiwhjpmdj" "areyqmyonskvzupalfiwhjcidb" "xregqpyonskvzuaalfiwhjctdy" "xwegumyonskvzuphlfiwhjctdb" "xregumymnskvzupalfiwhjctib" "xregqmyonjkvzupalfvwijctdb" "xrmgqmyonsdvzupalfiwhjcthb" "xrpgqmyonskvzupalfiwhcitdb" "xregvmysnsjvzupalfiwhjctdb" "xregqsyonskvzupgqfiwhjctdb" "qreuqmyonskvzupalfiwyjctdb" "xrecqmyenskvzupalyiwhjctdb" "xmegqmyonskvzhpalfcwhjctdb" "xiegqmyonskvzupalfkwhjjtdb" "xreaqmyofskfzupalfiwhjctdb" "xregqmypnskvzupalmiwhjltdb" "xretqmmonskvzupalfiwhwcfdb" "xrexqmkonskvzupalfiwjjctdb" "xrigqmyonskvgupplfiwhjctdb" "xregqmyotskvzupalfywhjctdm" "xcegmmyonsvvzupalfiwhjctdb" "xrezqmypnskvznpalfiwhjctdb" "xragqmyonskvzupblfiwajctdb" "xregqmyonskvzwpapfiwhjctqb" "xoegqmyoyskvzupaufiwhjctdb" "xrcgqmyjnskvzupalfcwhjctdb" "xregqmyonskvzudalfipajctdb" "xsegqmyonsklzupalwiwhjctdb" "xregqmyocskvduaalfiwhjctdb" "xhegqmyfnskvzupalflwhjctdb" "xregqmymnykvzupalfiwhjctdm" "xregqmybnskvzupacfiwdjctdb" "xaegqmlonskvzfpalfiwhjctdb" "xoegtmyonskvzupalfiwhwctdb" "xregqmyohskvzupaqfiwhjccdb" "xoegqmyonstvzupalfiwhjctbb" "mregnmyonskszupalfiwhjctdb" "xreoqmycnskvzupalfiphjctdb" "xregqmyocskvdupacfiwhjctdb" "xregqmyonskvzupajqiahjctdb" "xregqmyonslvwupalfiwhjcfdb" "xregqmyonskvzapalfiwhqcthb" "xrerqmyonskwzupalfiwhjctdt" "xrefqmfonskvzupalfiwcjctdb" "xregqmyonskvzupadfiwhjxedb" "iregqhyonskvzupaliiwhjctdb" "iregqmyotskvzucalfiwhjctdb" "xrbgqmaonrkvzupalfiwhjctdb" "xregqmyonskvzupalfixhdctdf" "xrehqmyonskvzupalfiwijctdd" "xvegqmyonskvzupaleuwhjctdb" "xregqmyiyskvzupalfiwqjctdb" "hregqmyonskvzupaxfiwhjptdb" "xregamyznskbzupalfiwhjctdb" "xreyqmyonskvgupalziwhjctdb" "xregqmysnskvzupalfiwhgctdu" "xojgqmyonskvzupalfiwbjctdb" "xrkgqmyonskvlupalfiwhjcwdb" "xregqmyonwkvxupalfiwajctdb" "xregqmyonsuvzupalfjwhjcxdb" "xregqmyonskgzucalfiwhjstdb" "xaegqmyonfkvzupalfiwhjcttb" "xlegqmyonskvzupazfiwhjctqb" "xrejqmyonskvzqpaldiwhjctdb" "xreguryonskvzupalfiwhjctdz" "xregqsyoeskvzupalfiwhjctdt" "xregqmyonskvzubalfirhjctdp" "xrepqmymnskvzupadfiwhjctdb" "xregqayonskvzuoalfichjctdb" "xreqqmyonskvzunalfiwojctdb" "xregqmyonsivzufalciwhjctdb" "xregqqeonskvzupanfiwhjctdb" "xoegqmyunskvzppalfiwhjctdb" "xregqmyonskvzupalfqwhnftdb" "xregqmyonskvzuralkiwhjcudb" "xrwgqmymnskvzupalfiwhjcgdb" "xvrgqmyonskvzupalfiwhjcthb" "xregemyonskkzupalfiwhjctbb" "xregqmyonsevzupalfiwhjjtdl" "xregqmyonckvcupajfiwhjctdb" "xregqmysnskvzunalfnwhjctdb" "xreowmyonskvkupalfiwhjctdb" "xregqmyonskvjupalfiwhjytdr" "xregqmyonskyzupaffiwhmctdb" "xrsgqmyonszvzupmlfiwhjctdb" "xzegqmyonskvnupalfiwfjctdb" "qregqmyonskvzupalfiwhrctjb" "xpegqmyonsivzupqlfiwhjctdb" "xregqmyoyskrzupalfiwhjctdx" "xregqmyonsqvzupalfiwhjdndb" "xregjmyonskvzppalfiwhjcgdb" "xregqmyziskvzupalfiwhjctib" "xregqmyonmkvbupalfiwhjckdb" "xtegamyonskvzupalniwhjctdb" "xregqpyonskvzhpwlfiwhjctdb" "xvegqmfonskvzupalfiwhjcadb" "xregqmyonskvzupaysiwhjctxb" "xrejqmyonudvzupalfiwhjctdb" "llegqmyonskvzbpalfiwhjctdb" "tcegqmbonskvzupalfiwhjctdb" "lregqmyohskvzupalfiwhjcttb" "xrngqmcfnskvzupalfiwhjctdb" "xregqmyonspvzuuplfiwhjctdb" "xrxgqmyonslvzupalfiwhjctdo" "xregqmyonskvzulalfuwhjdtdb" "xregqmnonskvzupalfvwhjckdb" "xregqbyfnskvzupaltiwhjctdb" "xregqmyodsovzwpalfiwhjctdb" "xregomyonskvhrpalfiwhjctdb" "xregqmfdnskvzupalliwhjctdb" "xregqmyonskvzupaabithjctdb" "xrngamyonskvzupalfiwhjcttb" "xrhgqmyonskvzupaldifhjctdb" "xrygzmyonskvzupatfiwhjctdb" "xregqmyonskvzupiqtiwhjctdb" "xregqmyonfkvzupalfiwxjcsdb" "xregqsyunskvzupalfiwhjctde" "xrzgqmyolskvzupasfiwhjctdb" "xgegqmyoyskvzupalfiwfjctdb" "xrvgqlyohskvzupalfiwhjctdb" "xregcmyonskvzuprlyiwhjctdb" "xregqmyonskvwjpalfiwsjctdb" "xrfgqmyonskvzupalfidhactdb" "xcegqmyonwkvzdpalfiwhjctdb" "nregqmyrnskvzupalciwhjctdb" "xcegqmyonskvzvpalfiwhjctdj" "xregqmyonskvzupqssiwhjctdb" "xregcmyonskvzupalfinhjutdb" "xregqmyonskvzupzlfiwcjctnb" "xnegqmyozskvzbpalfiwhjctdb" "xregvmponskvzupalfiwhsctdb" "xregqmyonskvpupalqichjctdb" "xreqqmyonskvzupauuiwhjctdb" "xregqryonskvzupatfiwhjctyb" "hregqmyonokvzupalfiwhmctdb" "xreuqmionckvzupalfiwhjctdb" "xregqmyoiskvzupanfiwhjntdb" "xrdgqmronskvzupaluiwhjctdb" "xadgqmyunskvzupalfiwhjctdb" "eregqmzonskvzupakfiwhjctdb" "xiegqmyonskvnupblfiwhjctdb" "yregqmzonskvzupalfiwhjotdb" "xregqmyonskvjupalfiwhjhtvb" "wregqmyonskvzzprlfiwhjctdb" "xregqmyovskvzupalgiuhjctdb" "xregqmyonskjzupelfuwhjctdb" "xregqmysuskvpupalfiwhjctdb" "xrebqkyonskvzupalfiwpjctdb" "xregcmyonskvzipalfiwhjcttb" "xregqmyonskdyupalfiwgjctdb" "xregcmyonskvzupalfiwijctnb" "xregqmyonsovdupalfrwhjctdb" "xregqmaonskvzupalnkwhjctdb" "xregqmysnfkvzupalfiwhictdb" "xregqmyonswvzupalfiyhjctdf" "xreoqmyrnskvzupalfihhjctdb" "tregqmydnskvzupalfizhjctdb" "xregxmyonykvzupalfnwhjctdb" "xzegqnyonskuzupalfiwhjctdb" "xregqmfonszvvupalfiwhjctdb" "xrerqmyjnskvzupalfiwhpctdb" "xregqmyanskvzupalffphjctdb" "rregqmyogskvzupalfiehjctdb" "xrpgqmyonspvzupalfiwgjctdb" "xuegqmppnskvzupalfiwhjctdb" "xregqmyonskvzqpalsiwhjhtdb" "xregqzyonskvzkpalfiwujctdb" "xrdgqmyonskvzupglfiwhjctdu" "xregqmyonskqzupahciwhjctdb" "treqqmyonskvzupalfiwhjcqdb" "vlegqmyonskvzupalfiwhjwtdb" "xregjmyonskviupglfiwhjctdb" "xreggmyanskvzupalfiwhjcydb" "xregqmybnskvzuprlfiwhjmtdb" "xrsgqmyonskizupagfiwhjctdb" "xregqmyenskvzupalfvwhjctib" "lrygqmyonsrvzupalfiwhjctdb" "xregqmjonskvqupalfiwhjctdu" "xregqmyonsknzmpzlfiwhjctdb" "xregqmyonhkvzupllfiwhjctdz" "xregqmronskvdumalfiwhjctdb" "xrpgqmyonskvzupalfhwhjhtdb" "xfegqmeonskvzupasfiwhjctdb" "xregqqyonskvzrpalfiwijctdb" "xretqmmonskvzupalfiwhjcfdb" "xregqmyonskvznpalniwhjztdb" "xregqmyqnskvzuoalfiwhhctdb" "xregqmyonsbvzupalviwhjxtdb" "xregqmyonskvzupazmiwhhctdb" "xregqmyosskvzupalflwhjctdw" "xtegqmyonskvzupamciwhjctdb" "xregamyonskvzbpalfiwhqctdb" "xregqmgonskvzupalfiwhictxb" "xregqmyonskvjupvlfnwhjctdb" "xrthqmyonskvzupalfiwhjctub" "xrexqmyoyskvzupalfiwhjcadb" "xvegqmyonskvxupalfiwhjztdb" "xregqmyonskgzupalhiwhjptdb" "xregqmysnskvzufalpiwhjctdb" "xregqmyonskvbipalfighjctdb" "xregqmyonskvzupylfiwhjwvdb" "gregqmyonskvzupalfikhjctdt" "ujegqmyonskvzupalfiwhjctlb" "nreqqmyonskjzupalfiwhjctdb" "xregqmyonskvzupanfbwhjchdb" "xregqyyoeskwzupalfiwhjctdb" "xregqmyokskvzgpalfiwhnctdb" "lregqmyonskvzupalfawsjctdb" "xtegqmyonskvzmpalfiwhjctmb" "xtegqvyonskvzupalfiwhjdtdb" "xpegqpyonekvzupalfiwhjctdb" "qregqmyonskvzupalfiwmjctdn" "xregqnyosskvzupalfibhjctdb" "xregqmyonsknzupalflwhjctfb" "xregqmxoyskvzuealfiwhjctdb" "xregdmyoeskvzupalfiwhfctdb" "xremmmyonskvzupalfiwhxctdb" "xregqmconskvzupylfuwhjctdb" "xregqmyonskvzupawiiwhictdb" "xlegsmyonskvzupalfiwhbctdb" "xregqmyonsavzopalyiwhjctdb" "xregqmyonskczupalfibhvctdb" "xregqmyonskvzvpalfiunjctdb" "xregqmyonskvdupalfiwhjczdp" "xregqmyonskvzupklfswhhctdb" "xrelqmyonskvzupalyiwhjctdi" "xrcgqmyonskvzupalfieqjctdb" "xregqmnonskvzupacfewhjctdb" "xrwgqmyonskvzuealfiwhcctdb" "xregqiyonsevzmpalfiwhjctdb" "xregqmyonjyvzupalfiwhjckdb" "xregqmyonyklzupadfiwhjctdb" "xregqmyanskvzupolfiwhjctpb" "xdbgqmyonskvzupslfiwhjctdb" "xregqmhonykvzupalfawhjctdb" "xregqmqonsivzupalfifhjctdb" "xregqgyonsrvzupalfiwhjctib" "xregqmyofskvzupalfiwlfctdb" "xregqmyovskvzupllftwhjctdb" "xregqmyonskvzupaciiwhuctdb" "xregqmyonsdvzuhalfiwhjhtdb" "xreiqmyonskvzupalfiwhncldb" "xregqmyongkvzugalfiwhjctxb" "xregqsyonskvzrpmlfiwhjctdb" "xrogqmyonskvzxpalfiwhbctdb" "xregqmkonskvzuqalfiwhjptdb" "xregqmyonskvvxpalfiwhactdb" "xregqmyonskvzupsliiwhwctdb"])
(prn (str "Answer task 1: " (compute inputPuzzle)))

(def example2 ["abcde" "fghij" "klmno" "pqrst" "fguij" "axcye" "wvxyz"])

(defn hasOneDiffrentChar [[word1 word2]]
    (= 1
    (count
    (filter false?
    (map = word1 word2
)))))

(prn (str "Example 1 (abcde and axcye): " (hasOneDiffrentChar ["fghij" "fguij"]) " = false"))
(prn (str "Example 2 (fguij and fghij): " (hasOneDiffrentChar ["fghij" "fguij"]) " = true"))

(defn getDiffChar [vectorOfWords]
    (first
    (filter hasOneDiffrentChar
    (for [x vectorOfWords y vectorOfWords] (vector x y))
)))

(defn getEqualChars [[word1 word2]]
    (apply str
    (distinct
    (flatten
    (filter (fn [[x y]] (= x y))
    (map vector word1 word2)
)))))

(prn (str "Answer task 2: " (getEqualChars (getDiffChar inputPuzzle))))