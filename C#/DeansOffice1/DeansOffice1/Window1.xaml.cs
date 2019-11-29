using DeansOffice1.DAL;
using DeansOffice1;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Text.RegularExpressions;

namespace DeansOffice1
{
    /// <summary>
    /// Logika interakcji dla klasy Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        List<string> selectedItem;
        public StudentsDbService student { get; set; }
        public Window1()
        {
        InitializeComponent();
        DataContext = new ViewModel();
        }


            private void Button1_Click(object sender, RoutedEventArgs e)
            {

                Regex reg = new Regex(@"s([0-9]{4})");
                Match match = reg.Match(textBoxIndeks.Text);

                selectedItem = new List<string>();
                foreach (String item in listBoxPrzedmioty.SelectedItems)
                {
                    selectedItem.Add(item);
                }

                if (match.Success && selectedItem.Count >= 1 && textBoxImie.Text.Length>=3 &&
                    textBoxNazwisko.Text.Length >= 3 && comboBoxStudia.SelectedItem != null &&
                    listBoxPrzedmioty.SelectedItem != null
                    )
                {
                    student = new StudentsDbService
                    {
                        Nazwisko = textBoxNazwisko.Text,
                        Imie = textBoxImie.Text,
                        NrIndeksu = textBoxIndeks.Text,
                        Studia = comboBoxStudia.Text,
                        przedmioty = selectedItem
                    };
                    MainWindow.listaStudentow.Add(student);
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Nieprawidlowo uzupełnione pola!");
                }
            }


        private void Button2_Click(object sender, RoutedEventArgs e)
            {


                this.Close();

            }
        }

        internal class ViewModel
        {
            public ObservableCollection<string> listOfStudies { get; set; }
            public ObservableCollection<string> listOfPrzedmioty { get; private set; }

            public ViewModel()
            {
                listOfStudies = new ObservableCollection<string>
            {
            "PJATK",
            "SWPS"
            };
                listOfPrzedmioty = new ObservableCollection<string>
            {
            "Matma", "Informatyka", "Przyroda", "C#"
            };
            
        }
    }
}
