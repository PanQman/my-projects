using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using DeansOffice1.DAL;

namespace DeansOffice1
{
    /// <summary>
    /// Logika interakcji dla klasy Edycja.xaml
    /// </summary>
    public partial class Edycja : Window
    {
        private StudentsDbService student;
        List<string> selectedItem;

        public Edycja(StudentsDbService student)
        {
            this.student = student;
            DataContext = new ViewMode2(student);
            InitializeComponent();
        }

        private void Button1_Click(object sender, RoutedEventArgs e)
        {
            Regex reg = new Regex(@"^[a-zA-Z]+$");
            Match match = reg.Match(textBoxIndeks.Text);

            selectedItem = new List<string>();
            foreach (String item in listBoxPrzedmioty.SelectedItems)
            {
                selectedItem.Add(item);
            }

            if (match.Success && selectedItem.Count >= 1 && textBoxImie.Text.Length >= 3 &&
                textBoxNazwisko.Text.Length >= 3 && comboBoxStudia.SelectedItem != null &&
                listBoxPrzedmioty.SelectedItem != null
                )
            {

                var item = MainWindow.listaStudentow.FirstOrDefault
                    (i => i.Nazwisko == student.Nazwisko && i.Imie == student.Imie
                    && i.Studia == student.Studia
                    && i.przedmioty == student.przedmioty);

                if (item != null)
                {
                    item.Nazwisko = textBoxNazwisko.Text;
                    item.Imie = textBoxImie.Text;
                    item.Studia = comboBoxStudia.Text;
                    item.przedmioty = selectedItem;
                }
                OnPropertyChanged();
                this.Close();
                OnPropertyChanged();
                
            }
            else
            {
                MessageBox.Show("Nieprawidlowo uzupełnione pola!");
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChangedEventHandler handler = PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        private void Button2_Click(object sender, RoutedEventArgs e)
        {

            
            this.Close();

        }
    }




    internal class ViewMode2
    {
        public string NrIndeksu { get; set; }
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public string Adres { get; set; }
        public List<string> Studia { get; set; }
        public List<string> przedmioty { get; set; }
        public ViewMode2(StudentsDbService sd)
        {
            Studia = new List<string>();
            przedmioty = new List<string>();
            NrIndeksu = sd.NrIndeksu;
            Imie = sd.Imie;
            Nazwisko = sd.Nazwisko;
            Adres = sd.Adres;
            Studia.Add(sd.Studia);
            przedmioty = sd.przedmioty;
            
        }
    }
}

