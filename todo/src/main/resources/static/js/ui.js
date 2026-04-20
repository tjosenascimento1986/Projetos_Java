const ui = {
    // Renderiza a lista de tarefas no HTML
    render(tarefas) {
        const container = document.getElementById('listaTarefas');
        if (tarefas.length === 0) {
            container.innerHTML = '<p style="text-align:center; color:#94a3b8; margin-top:40px;">Nenhuma tarefa encontrada.</p>';
            return;
        }
        container.innerHTML = tarefas.map(t => this.createCard(t)).join('');
    },

    // Cria o HTML de cada card
    createCard(t) {
        const concluidaClass = t.concluido ? 'tarefa-concluida' : '';
        const checkIconClass = t.concluido ? 'icon-active' : 'text-check';

        // Cores de prioridade
        const corPrio = {
            'ALTA': '#ef4444',
            'MEDIA': '#f59e0b',
            'BAIXA': '#10b981'
        }[t.prioridade] || '#64748b';

        return `
            <div class="card-tarefa ${concluidaClass}">
                <div style="flex: 1;">
                    <div style="display: flex; gap: 8px; align-items: center; margin-bottom: 5px;">
                        <span class="badge">${t.categoria}</span>
                        <span style="color: ${corPrio}; font-size: 10px; font-weight: 900;">● ${t.prioridade}</span>
                    </div>
                    <h3 style="margin: 0; font-size: 1.1rem;">${t.titulo}</h3>
                    <p style="margin: 5px 0 0; font-size: 0.85rem; color: #64748b;">${t.descricao || ''}</p>
                </div>
                
                <div class="actions">
                    <button onclick="ui.edit('${t.id}', '${t.titulo.replace(/'/g, "\\'")}', '${(t.descricao || "").replace(/'/g, "\\'")}', '${t.prioridade}', '${t.categoria}')" 
                            class="btn-icon text-edit" title="Editar">
                        <i class="fas fa-edit"></i>
                    </button>
                    <button onclick="api.toggleConcluir(${t.id})" 
                            class="btn-icon ${checkIconClass}" title="Concluir">
                        <i class="fas fa-check-circle"></i>
                    </button>
                    <button onclick="api.excluir(${t.id})" 
                            class="btn-icon text-delete" title="Excluir">
                        <i class="fas fa-trash"></i>
                    </button>
                </div>
            </div>
        `;
    },

    // Prepara o formulário para edição
    edit(id, tit, desc, prio, cat) {
        document.getElementById('taskId').value = id;
        document.getElementById('titulo').value = tit;
        document.getElementById('descricao').value = desc;
        document.getElementById('prioridade').value = prio;
        document.getElementById('categoria').value = cat;

        const btn = document.getElementById('btnSubmit');
        document.getElementById('formTitle').innerText = "Editando Tarefa";
        btn.innerText = "Atualizar Tarefa";
        btn.classList.add('edit-mode');
        document.getElementById('btnCancelar').classList.remove('hidden');

        window.scrollTo({ top: 0, behavior: 'smooth' });
    },

    // Limpa o formulário e volta ao estado original
    resetForm() {
        document.getElementById('taskForm').reset();
        document.getElementById('taskId').value = '';
        document.getElementById('formTitle').innerText = "Nova Tarefa";

        const btn = document.getElementById('btnSubmit');
        btn.innerText = "Salvar Tarefa";
        btn.classList.remove('edit-mode');
        document.getElementById('btnCancelar').classList.add('hidden');
    }
};

// Listener do Formulário (Salvar/Editar)
document.getElementById('taskForm').addEventListener('submit', (e) => {
    e.preventDefault();
    const id = document.getElementById('taskId').value;
    const tarefa = {
        titulo: document.getElementById('titulo').value,
        descricao: document.getElementById('descricao').value,
        prioridade: document.getElementById('prioridade').value,
        categoria: document.getElementById('categoria').value
    };

    api.salvar(tarefa, id || null);
    ui.resetForm();
});