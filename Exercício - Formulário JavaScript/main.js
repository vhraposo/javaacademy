const form = document.querySelector('#formulario');
const saveButton = document.querySelector('#salvar');

const name = document.querySelector('#nome')
const surname = document.querySelector('#sobrenome') 
const login = document.querySelector('#login')
const password = document.querySelector('#senha');



const cepInput = document.querySelector('#cep');
const address = document.querySelector('#endereco');
const complement = document.querySelector('#complemento');
const neighborhood = document.querySelector('#bairro');
const city = document.querySelector('#cidade');
const state = document.querySelector('#estado');
const cepErro = document.querySelector('#cep-erro');

const githubProfile = document.querySelector('#perfil-github');
const academia = document.querySelector('#academia');
const professor = document.querySelector('#professor');



function generateLogin(){
    const nameInput = name.value.toLowerCase().trim()
    const surnameI = surname.value.toLowerCase().trim()

    // aqui utilizei uma expressão regular para substituir os espaços em branco por um string vazia
    const loginI = `${nameInput}.${surnameI}`.replace(/\s/g,'')

    login.value = loginI;

}
 // aqui ele vai prencher o campo de login com o que foi digitado nos campos de nome e sobrenome
name.addEventListener( 'input', () =>  generateLogin())  
surname.addEventListener( 'input',() => generateLogin())


// aqui pe uma função que vai fazer o fetch do via cep e caso localizar, irá preencher os campos automaticamente 

function preencherEndereco() {
  
  
    const cep = cepInput.value;
  
    if (cep.length !== 8) {
      cepErro.classList.remove('d-none');
      return;
    }
  
    cepErro.classList.add('d-none');
  
    fetch(`https://viacep.com.br/ws/${cep}/json/`)
      .then(response => response.json())
      .then(data => {
        if (data.erro) {
          cepErro.classList.remove('d-none');
          return;
        }
  
        cepErro.classList.add('d-none');
        address.value = data.logradouro;
        complement.value = data.complemento;
        neighborhood.value = data.bairro;
        city.value = data.localidade;
        state.value = data.uf;
      })
      .catch(error => {
        console.error('Erro ao fazer o fetch:', error);
      });
  }
  
  //chamando a função
  cep.addEventListener('blur', preencherEndereco);

  

// aqui ele vai salvar o formulario e executar a função de submit
  saveButton.addEventListener('click', () => {
    alert('Os dados foram salvos com sucesso!');
    submitForm();
  });
  
  function submitForm() {
    const formData = new FormData(form);
  
    // aqui ele vai percorrer todas as entradas do formulario e exibir no console 
    for (let pair of formData.entries()) {
      console.log(pair[0] + ': ' + pair[1]);
    }
  
    // e por ultimo ira enviar esses dados
    form.submit();
}
  
  
  


