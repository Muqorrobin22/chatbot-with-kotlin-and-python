knowledge = [
    {
        'gejala': ['demam', 'bersin', 'batuk', 'sakit tenggorokan', 'hidung meler', 'nyeri sendi', 'nyeri badan', 'sakit kepala', 'badan lemas'  ],
        'penyakit': 'Influenza/Flu'
    },
    {
        'gejala': ["nyeri Kepala", "nyeri kepala ringan", 'otot tegang', "nyeri leher belakang", 'kepala berat', 'pegal'],
        'penyakit': 'Tipes'
    }
]

rules = [
    {
        'gejala' : 'demam', 'bobot' : 15, 'penyakit': "Influenza/Flu"
    },
    {
        'gejala' : 'pilek', 'bobot' : 20, 'penyakit' : 'Influenza/Flu'
    },
    {
        'gejala' : 'meriang', 'bobot' : 10, 'penyakit' : 'Influenza/Flu'
    },
    {
        'gejala' : 'bersin', 'bobot' : 10, 'penyakit': 'Influenza/Flu'
    },
    {
        'gejala' : 'batuk', 'bobot' : 15, 'penyakit' : "Influenza/Flu"
    },
    {
        'gejala' : 'sakit tenggorok', 'bobot': 15, 'penyakit': "Influenza/Flu"
    },
    {
        'gejala' : 'hidung meler', 'bobot': 15, 'penyakit': "Influenza/Flu"
    },
    {
        'gejala' : 'nyeri sendi', 'bobot' : 5, 'penyakit' : "Influenza/Flu"
    },
    {
        'gejala' : 'sakit kepala', 'bobot': 15, 'penyakit' : 'Influenza/Flu'
    },
    {
        'gejala' : "panas" , 'bobot' : 15, 'penyakit' : 'Influenza/Flu'
    },
    {
        'gejala' : 'badan lemas', 'bobot' : 5, 'penyakit' : 'Influenza/Flu'
    },
    {
        'gejala' : 'tegang otot', 'bobot' : 5, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala': 'nyeri leher', 'bobot' : 5, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala' : 'nyeri menjalar', 'bobot': 10, 'penyakit': 'Tension Headache'
    },
    {
        'gejala': 'kepala berat', 'bobot' : 10, 'penyakit': 'Tension Headache'
    },
    {
        'gejala': 'pegal', 'bobot': 5, 'penyakit': 'Tension Headache'
    },
    {
        'gejala' : 'insomnia', 'bobot': 5, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala' : 'nafas pendek', 'bobot' : 10, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala' : 'gangguan haid', 'bobot' : 5, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala' : 'nyeri kepala', 'bobot' : 20, 'penyakit' : 'Tension Headache'
    },
    {
        'gejala' : 'sakit kepala', 'bobot' : 10, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'panas', 'bobot' : 5, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'badan lemas', 'bobot': 5, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'tegang otot', 'bobot': 10, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'mual', 'bobot': 10, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'muntah', 'bobot': 10, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'pusing', 'bobot' : 20, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'keringat dingin', 'bobot' : 10, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'rasa goyang', 'bobot': 15, 'penyakit': 'Vertigo'
    },
    {
        'gejala' : 'layang', 'bobot' : 10, 'penyakit': 'Vertigo'
    },
    {
        'gejala' : 'nyeri kepala', 'bobot': 15, 'penyakit' : 'Vertigo'
    },
    {
        'gejala' : 'demam', 'bobot': 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'panas', 'bobot': 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'mual', 'bobot': 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'muntah', 'bobot': 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'pusing', 'bobot': 20, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'nyeri kepala', 'bobot' : 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'insomnia', 'bobot': 5, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'keringat dingin', 'bobot' : 5, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'sakit kepala', 'bobot' : 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'rasa goyang', 'bobot' : 15, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'nyeri menjalar', 'bobot' : 10, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'denyut', 'bobot' : 15, 'penyakit' : 'Migren'
    },
    {
        'gejala' : 'kulit merah', 'bobot' : 20, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'keram', 'bobot' : 5, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala': 'nyeri kepala' , 'bobot' : 10, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'denyut', 'bobot' : 5, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'mual', 'bobot' : 15, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'muntah', 'bobot' : 15, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'insomnia', 'bobot' : 10, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'berat', 'bobot' : 5, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'badan lemas', 'bobot' : 5, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'sakit kepala', 'bobot' : 10, 'penyakit': 'Alergi Makanan'
    },
    {
        'gejala' : 'sakit perut', 'bobot' : 20, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'kulit gatal', 'bobot' : 20, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'merah', 'bobot' : 10, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'nyeri perut', 'bobot': 20, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'keram', 'bobot' : 5, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'diare', 'bobot': 20, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'bintik', 'bobot' : 15, 'penyakit' : 'Alergi Makanan'
    },
    {
        'gejala' : 'pandang buram', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'merah', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'kulit gatal', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'nyeri perut', 'bobot': 20, 'penyakit' : 'Keracunan Makanan~'
    },
    {
        'gejala' : 'meriang', 'bobot' : 10, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'sakit perut', 'bobot' : 15, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'diare', 'bobot' : 20, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'sesak nafas', 'bobot' : 5, 'penyakit': 'Keracunan Makanan'
    },
    {
        'gejala' : 'nyeri kepala', 'bobot' : 10, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'denyut', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'keringat dingin', 'bobot' : 15, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'mual', 'bobot': 20, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'muntah', 'bobot' : 20, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'nafas pendek', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'pusing', 'bobot' : 10, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'badan lemas', 'bobot' : 5, 'penyakit': 'Keracunan Makanan'
    },
    {
        'gejala' : 'panas', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    },
    {
        'gejala' : 'demam', 'bobot' : 5, 'penyakit' : 'Keracunan Makanan'
    }
]