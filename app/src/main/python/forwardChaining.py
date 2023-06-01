from knowledgeDisease import knowledge

def forward_chaining(input_user):
    penyakit = []
    for rule in knowledge:
        if set(input_user).issubset(rule['gejala']):
            penyakit.append(rule['penyakit'])
    return penyakit;


def forward_chaining2(fakta, aturan):
    diagnosis = {}
    bobot_tertinggi = 0
    for i in range(len(aturan)):
        if aturan[i]['gejala'] in fakta and fakta[aturan[i]['gejala']]:
            penyakit = aturan[i]['penyakit']
            bobot = aturan[i]['bobot']
            if penyakit in diagnosis:
                diagnosis[penyakit] += bobot
            else:
                diagnosis[penyakit] = bobot

    if diagnosis:
        bobot_tertinggi = max(diagnosis, key=diagnosis.get)
        if diagnosis.get(bobot_tertinggi) < 50:
            return "Mohon maaf kami belum bisa mendiagnosa dari gejala yang anda masukkan.\n" \
                   "Silahkan memasukkan lagi gejala yang anda alami"
        else:
            return "Dari Gejala yang anda sampaikan, diagnosa kami adalah anda mengalami {0}.\n\n" \
                   "Langkah penyembuhannya bisa beristirahat yang cukup dan makan makanan bergizi." \
                   " Apabila dirasa gejala yang anda alami sudah lebih dari 5 hari maka sebaiknya silahkan" \
                   " rujuk ke Rumah Sakit, Puskesmas, atau Klinik Terdekat anda.\n\n" \
                   "Terima kasih dan Sehat Selalu 😊".format(bobot_tertinggi)
    else :
        return "Mohon maaf Gejala yang anda sebutkan tidak bisa kami kenali.\n" \
               "Silahkan memasukkan lagi nama gejala dengan benar.\n" \
               "Terima Kasih"