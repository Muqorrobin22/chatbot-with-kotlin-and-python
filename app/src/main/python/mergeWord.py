word_predict = ['sakit', 'nyeri', 'hidung', 'tegang', 'rasa', 'kulit', 'pandang', 'badan', 'sesak', 'keringat']


def merge_some_word_in_list(list_some_word):
    new_merge_word = list_some_word.copy()
    len_merge = len(new_merge_word)
    for index_el in range(len(new_merge_word)):
        for word in range(len(word_predict)):
            if index_el < len(new_merge_word):
                if new_merge_word[index_el] == word_predict[word]:
                    index_baru = index_el + 2
                    new_word = new_merge_word[index_el:index_baru]
                    to_string = ' '.join(new_word)
                    new_merge_word.append(to_string)
                    continue

    del new_merge_word[:len(list_some_word)]
    return new_merge_word


def omit_merge_word(list_some_word):
    new_omit_word = list_some_word.copy()
    targetted_index = []
    for index_el in range(len(new_omit_word)):
        for word in range(len(word_predict)):
            if index_el < len(new_omit_word):
                if new_omit_word[index_el] == word_predict[word]:
                    targetted_index.append(index_el)
                    targetted_index.append(index_el + 1)
                    # del new_omit_word[index_el:index_baru]
                    continue

    for i in sorted(targetted_index, reverse=True):
        del new_omit_word[i]

    return new_omit_word


def merge_all_word_to_one_list(list1, list2):
    merged_list = list1 + list2
    result = []

    for item in merged_list:
        if item not in result:
            result.append(item)

    return result