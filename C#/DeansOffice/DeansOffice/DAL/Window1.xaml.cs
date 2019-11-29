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


namespace DeansOffice.DAL
{
    /// <summary>
    /// Logika interakcji dla klasy Window1.xaml
    /// </summary>
    /// 
    
    public partial class Window1 : Window
    {
        List<string> selectedItem;
        public Window1()
        {

            InitializeComponent();
            DataContext = new ViewModel();
            
        }
        

        private void Button1_Click(object sender, RoutedEventArgs e)
        {

            this.Close();

            StudentsDbService studentsDbService = new StudentsDbService
            {
                
                Nazwisko = textBoxNazwisko.ToString(),
                Imie = textBoxImie.ToString(),
                NrIndeksu = textBoxIndeks.ToString(),
                Studia = comboBoxStudia.ToString(),
                przedmioty = selectedItem,
                //Adres = "sadasc"
            };
            MainWindow ma = new MainWindow();
            ma.DodajStudenta(studentsDbService);
            
           
           
        }

        private void Button2_Click(object sender, RoutedEventArgs e)
        {
            selectedItem = new List<string>();
            foreach (String item in listBoxPrzedmioty.SelectedItems)
            {
                selectedItem.Add(item);
            }

            this.Close();
            
        }
    }

    internal class ViewModel
    {
        public ObservableCollection<string> listOfStudies { get; private set; }
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
