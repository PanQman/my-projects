using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace DeansOffice1.DAL
{
    public class StudentsDbService 
    {
        public string NrIndeksu { get; set; }
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public string Adres { get; set; }
        public string Studia { get; set; }
        public List<string> przedmioty { get; set; }


    
        public override string ToString()
        {
            return $"{Nazwisko} {Imie} {NrIndeksu} {Adres} {Studia} {przedmioty}";
        }

    }
}
