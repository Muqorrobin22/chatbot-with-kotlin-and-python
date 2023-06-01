from nltk import regexp_tokenize
from Sastrawi.StopWordRemover.StopWordRemoverFactory import StopWordRemoverFactory
from Sastrawi.Stemmer.StemmerFactory import StemmerFactory
from datasets import stop_word_list_datasets
from knowledgeDisease import rules as aturan
from mergeWord import omit_merge_word
from mergeWord import merge_some_word_in_list
from mergeWord import merge_all_word_to_one_list
from forwardChaining import forward_chaining2
# from forward_chaining import forward_chaining

# Case Folding
# input_keluhan = input("Masukkan Keluhan : ").lower()

def textProcessing(input_keluhan):
    # Tokenizing
    regex_word = regexp_tokenize(input_keluhan, "[A-z]+")

    # Filtering -> StopWord
    stop_word = StopWordRemoverFactory().get_stop_words() + stop_word_list_datasets

    # Stemming
    stemmer = StemmerFactory().create_stemmer()

    # cek apakah input keluhan ada kata tambahan yang tidak diperlukan
    new_word = []
    for word in regex_word:
        if word not in stop_word:
            new_word.append(word)

    # Mengubah list new_word ke string agar bisa dimasukkan ke proses stemming
    list_to_string = ' '.join(new_word)

    # proses stemming tiap kata
    stemming_word = stemmer.stem(list_to_string)
    print(stemming_word)

    string_to_list = stemming_word.split(" ")
    # hasil = forward_chaining(string_to_list)

    #Gabungin dua kata
    omit_word = omit_merge_word(string_to_list)
    merge_word = merge_some_word_in_list(string_to_list)
    merged_all_word = merge_all_word_to_one_list(omit_word, merge_word)

    # list to dictionaries
    dict_word = {x : True for x in merged_all_word}

    # Forward chaining with new datasets bobot
    hasil2 = forward_chaining2(dict_word, aturan)

    return hasil2
