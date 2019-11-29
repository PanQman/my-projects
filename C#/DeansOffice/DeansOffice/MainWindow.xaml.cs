using DeansOffice.DAL;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DeansOffice
{
    /// <summary>
    /// Logika interakcji dla klasy MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        private static ObservableCollection<StudentsDbService> ListaStudentow;
        public static bool czyUsun;
        public MainWindow()
        {

            InitializeComponent();
            LoadDatatoTextBoxAndDataGrid();
            ListaStudentow.CollectionChanged += ListaStudentow_CollectionChanged;

            DataContext = this;
            
        }

        private void ListaStudentow_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            //MessageBox.Show("Coś się zmieniło w kolekcji");
        }

        private void LoadDatatoTextBoxAndDataGrid()
        {
            ListaStudentow = new ObservableCollection<StudentsDbService>();
            StudentsDataGrid.ItemsSource = ListaStudentow;
            LoadStudents();
            
            IdCounter = 0;
        }

        private void StudentsDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        public void LoadStudents()
        {
            using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
            using (var comm = new SqlCommand())
            {
                comm.Connection = con;
                comm.CommandText = "SELECT S.IdStudent, S.FirstName, S.LastName, S.IndexNumber, S.Address, ST.Name FROM s15269.apbd.Student S, s15269.apbd.Studies ST WHERE S.IdStudies = ST.IdStudies;";

                con.Open();
                using (SqlDataReader dr = comm.ExecuteReader())
                {
                    var list = new List<StudentsDbService>();
                    while (dr.Read())
                    {

                        string imie = dr["FirstName"].ToString();
                        string nazwisko = dr["LastName"].ToString();
                        string nrIndeksu = dr["IndexNumber"].ToString();
                        string adres = dr["Address"].ToString();
                        string studia = dr["Name"].ToString();

                        if (dr["IdStudent"] != DBNull.Value)
                        {
                            int idOsoba = (int)dr["IdStudent"];
                            //string plec = (string)dr["Plec"];

                            list.Add(new StudentsDbService
                            {
                                Nazwisko = nazwisko,
                                Imie = imie,
                                NrIndeksu = nrIndeksu,
                                Adres = adres,
                                Studia = studia
                            });
                        }
                    }
                }
            }
        }

        private void Usun_Click(object sender, RoutedEventArgs e)
        {
            if (System.Windows.Forms.MessageBox.Show("Czy na pewno chcesz usunąć dane studentów ?", "", 
                MessageBoxButtons.YesNo) == System.Windows.Forms.DialogResult.Yes)
            {
                while (StudentsDataGrid.SelectedItems.Count > 0)
                {
                    ListaStudentow.RemoveAt(StudentsDataGrid.SelectedIndex);
                }
                IdCounter = 0;
            }

   
        }
        
        private void Dodaj_Click(object sender, RoutedEventArgs e)
        {
            var win1 = new Window1();
            win1.ShowDialog();
           
        }

        public void DodajStudenta(StudentsDbService st)
        {
            ListaStudentow.Add(st);
            //IdCounter = 0;
            //StudentsDataGrid.ItemsSource = ListaStudentow;
        }


        private int count;
        public int IdCounter
        {
            get 
            {
                return count;
            }
            set
            {
                if (count != ListaStudentow.Count)
                {
                   count = ListaStudentow.Count;
                   OnPropertyChanged("IdCounter");
                }
            }
           
        }
        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string name)
        {
            PropertyChangedEventHandler handler = PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(name));
            }
        }

    }
}
